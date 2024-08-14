import cv2
vidcap = cv2.VideoCapture('BIXSCP630SC450574C03D1-20230323-081807-1679573887242-7.mp4.out.mp4')
success, image = vidcap.read()
count = 0
seconds = 30
print(success)

font = cv2.FONT_HERSHEY_SIMPLEX
org = (50, 50)
fontScale = 1
color = (255, 0, 0)
thickness = 2

while success and count < (30*seconds):
    image = cv2.putText(image, "TEST", org, font, fontScale, color, thickness, cv2.LINE_AA)
    cv2.imwrite("frames/frame%d.jpg" % (count), image)
    success, image = vidcap.read()
    print("Read a new frame: ", success)
    count += 1
