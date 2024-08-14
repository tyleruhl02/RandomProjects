import time

import cv2
import numpy as np
from matplotlib import pyplot as plt

# reading image
def get_hex_locations(input_image, numbers=False):

    img = cv2.imread(input_image)

    # converting image into grayscale image
    gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)

    #cv2.imshow('gray', gray)

    # setting threshold of gray image
    _, threshold = cv2.threshold(gray, 10, 255, cv2.THRESH_BINARY)

    # using a findContours() function
    contours, _ = cv2.findContours(
        threshold, cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE)

    i = 0

    locations = []

    # list for storing names of shapes
    for contour in contours:

        # here we are ignoring first counter because
        # findcontour function detects whole image as shape
        if i == 0:
            i = 1
            continue

        # cv2.approxPloyDP() function to approximate the shape
        approx = cv2.approxPolyDP(
            contour, 0.01 * cv2.arcLength(contour, True), True)

        #print(cv2.contourArea(approx))
        if numbers and cv2.contourArea(approx) > 200 and cv2.contourArea(approx) < 10000:
            pass
            #print(cv2.contourArea(approx))
        elif cv2.contourArea(approx) < 2000 or cv2.contourArea(approx) > 10000:
            continue
        #quit()

        # using drawContours() function
        cv2.drawContours(img, [contour], 0, (0, 0, 255), 2)

        # finding center point of shape
        M = cv2.moments(contour)
        if M['m00'] != 0.0:
            x = int(M['m10'] / M['m00'])
            y = int(M['m01'] / M['m00'])

            #cv2.putText(img, "HEXAGON", (x, y), cv2.FONT_HERSHEY_SIMPLEX, 0.6, (255, 255, 255), 2)

            locations.append((x, y))

    #cv2.imshow('shapes', img)

    #cv2.waitKey(0)
    #cv2.destroyAllWindows()

    return locations

#print(get_hex_locations("brick_mask.jpg"))
            #cv2.putText(img, "HEXAGON", (x, y), cv2.FONT_HERSHEY_SIMPLEX, 0.6, (255, 255, 255), 2)

            #continue

            # putting shape name at center of each shape
"""if len(approx) == 3:
            continue
            cv2.putText(img, 'Triangle', (x, y),
                        cv2.FONT_HERSHEY_SIMPLEX, 0.6, (255, 255, 255), 2)
    
        elif len(approx) == 4:
            continue
            cv2.putText(img, 'Quadrilateral', (x, y),
                        cv2.FONT_HERSHEY_SIMPLEX, 0.6, (255, 255, 255), 2)
    
        elif len(approx) == 5:
            continue
            cv2.putText(img, 'Pentagon', (x, y),
                        cv2.FONT_HERSHEY_SIMPLEX, 0.6, (255, 255, 255), 2)
    
        elif len(approx) == 6:
            cv2.putText(img, 'Hexagon', (x, y),
                        cv2.FONT_HERSHEY_SIMPLEX, 0.6, (255, 255, 255), 2)
    
        else:
            continue
            cv2.putText(img, 'circle', (x, y),
                        cv2.FONT_HERSHEY_SIMPLEX, 0.6, (255, 255, 255), 2)
    
        # displaying the image after drawing contours
    cv2.imshow('shapes', img)
    
    cv2.waitKey(0)
    cv2.destroyAllWindows()"""