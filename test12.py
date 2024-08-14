import numpy
import numpy as np
import matplotlib.pyplot as plt
from skimage.io import imshow, imread
from skimage.color import rgb2hsv, hsv2rgb
import cv2
from test11 import get_hex_locations
from pprint import pprint

def rgb_splitter(image):
    rgb_list = ['Reds','Greens','Blues']
    fig, ax = plt.subplots(1, 3, figsize=(15,5), sharey = True)
    for i in range(3):
        ax[i].imshow(image[:,:,i], cmap = rgb_list[i])
        ax[i].set_title(rgb_list[i], fontsize = 15)
    plt.show()


def display_as_hsv(image):
    img = cv2.imread(image)
    img_hsv = cv2.cvtColor(img, cv2.COLOR_BGR2HSV)

    hsv_list = ['Hue', 'Saturation', 'Value']
    fig, ax = plt.subplots(1, 3, figsize=(15, 7), sharey=True)

    ax[0].imshow(img_hsv[:, :, 0], cmap='hsv')
    ax[0].set_title(hsv_list[0], fontsize=20)
    ax[0].axis('off')

    ax[1].imshow(img_hsv[:, :, 1], cmap='Greys')
    ax[1].set_title(hsv_list[1], fontsize=20)
    ax[1].axis('off')

    ax[2].imshow(img_hsv[:, :, 2], cmap='gray')
    ax[2].set_title(hsv_list[2], fontsize=20)
    ax[2].axis('off')

    fig.tight_layout()
    plt.show()

def main():
    red_girl = imread('IMG_9954.jpg')
    plt.figure(num=None, figsize=(8, 6), dpi=80)
    imshow(red_girl)
    #plt.show()

    red_filtered_girl = (red_girl[:,:,0] > 150)
    plt.figure(num=None, figsize=(8, 6), dpi=80)
    imshow(red_filtered_girl, cmap = 'gray')
    #plt.show()

    red_girl_new = red_girl.copy()
    red_girl_new[:, :, 0] = red_girl_new[:, :, 0]*red_filtered_girl
    red_girl_new[:, :, 1] = red_girl_new[:, :, 1]*red_filtered_girl
    red_girl_new[:, :, 2] = red_girl_new[:, :, 2]*red_filtered_girl
    plt.figure(num=None, figsize=(8, 6), dpi=80)
    imshow(red_girl_new)
    #plt.show()

    #rgb_splitter(red_girl)

    red_filtered = (red_girl[:, :, 0] > 200) & (red_girl[:, :, 1] < 150) & (red_girl[:, :, 2] < 150)
    plt.figure(num=None, figsize=(8, 6), dpi=80)
    red_girl_new = red_girl.copy()
    red_girl_new[:, :, 0] = red_girl_new[:, :, 0] * red_filtered
    red_girl_new[:, :, 1] = red_girl_new[:, :, 1] * red_filtered
    red_girl_new[:, :, 2] = red_girl_new[:, :, 2] * red_filtered
    imshow(red_girl_new)
    #plt.show()

    #display_as_hsv("IMG_9954.jpg")

    red_girl_hsv = red_girl.copy()

    plt.figure(num=None, figsize=(8, 6), dpi=80)
    plt.imshow(red_girl_hsv[:, :, 0], cmap='hsv')
    plt.colorbar()
    #plt.show()

    plt.figure(num=None, figsize=(8, 6), dpi=80)
    plt.imshow(red_girl_hsv[:, :, 1], cmap='hsv')
    plt.colorbar()
    #plt.show()

    plt.figure(num=None, figsize=(8, 6), dpi=80)
    plt.imshow(red_girl_hsv[:, :, 2], cmap='hsv')
    plt.colorbar()
    #plt.show()

    lower_mask = red_girl_hsv[:, :, 0] > 140
    upper_mask = red_girl_hsv[:, :, 0] < 210
    saturation_upper = red_girl_hsv[:, :, 1] < 180
    saturation_lower = red_girl_hsv[:, :, 1] > 130
    value_upper = red_girl_hsv[:, :, 2] < 180
    value_lower = red_girl_hsv[:, :, 2] > 140
    mask = upper_mask * lower_mask * saturation_upper * saturation_lower * value_upper * value_lower * value_lower
    red = red_girl[:, :, 0] * mask
    green = red_girl[:, :, 1] * mask
    blue = red_girl[:, :, 2] * mask
    ore_masked = np.dstack((red, green, blue))
    plt.figure(num=None, figsize=(8, 6), dpi=80)
    imshow(ore_masked)
    plt.savefig("ore_mask.jpg")
    #plt.show()

    lower_mask = red_girl_hsv[:, :, 0] > 50
    upper_mask = red_girl_hsv[:, :, 0] < 150
    saturation_upper = red_girl_hsv[:, :, 1] < 160
    saturation_lower = red_girl_hsv[:, :, 1] > 130
    value_upper = red_girl_hsv[:, :, 2] < 120
    value_lower = red_girl_hsv[:, :, 2] > 60
    mask = upper_mask * lower_mask * saturation_upper * saturation_lower * value_upper * value_lower * value_lower
    red = red_girl[:, :, 0] * mask
    green = red_girl[:, :, 1] * mask
    blue = red_girl[:, :, 2] * mask
    wood_masked = np.dstack((red, green, blue))
    plt.figure(num=None, figsize=(8, 6), dpi=80)
    imshow(wood_masked)
    plt.savefig("wood_mask.jpg")
    #plt.show()

    lower_mask = red_girl_hsv[:, :, 0] > 120
    upper_mask = red_girl_hsv[:, :, 0] < 180
    saturation_upper = red_girl_hsv[:, :, 1] < 210
    saturation_lower = red_girl_hsv[:, :, 1] > 160
    value_upper = red_girl_hsv[:, :, 2] < 80
    value_lower = red_girl_hsv[:, :, 2] > 30
    mask = upper_mask * lower_mask * saturation_upper * saturation_lower * value_upper * value_lower * value_lower
    red = red_girl[:, :, 0] * mask
    green = red_girl[:, :, 1] * mask
    blue = red_girl[:, :, 2] * mask
    sheep_masked = np.dstack((red, green, blue))
    plt.figure(num=None, figsize=(8, 6), dpi=80)
    imshow(sheep_masked)
    plt.savefig("sheep_mask.jpg")
    #plt.show()

    lower_mask = red_girl_hsv[:, :, 0] > 200
    upper_mask = red_girl_hsv[:, :, 0] < 250
    saturation_upper = red_girl_hsv[:, :, 1] < 210
    saturation_lower = red_girl_hsv[:, :, 1] > 160
    value_upper = red_girl_hsv[:, :, 2] < 90
    value_lower = red_girl_hsv[:, :, 2] > 50
    mask = upper_mask * lower_mask * saturation_upper * saturation_lower * value_upper * value_lower * value_lower
    red = red_girl[:, :, 0] * mask
    green = red_girl[:, :, 1] * mask
    blue = red_girl[:, :, 2] * mask
    wheat_masked = np.dstack((red, green, blue))
    plt.figure(num=None, figsize=(8, 6), dpi=80)
    imshow(wheat_masked)
    plt.savefig("wheat_mask.jpg")
    #plt.show()

    lower_mask = red_girl_hsv[:, :, 0] > 190
    upper_mask = red_girl_hsv[:, :, 0] < 240
    saturation_upper = red_girl_hsv[:, :, 1] < 140
    saturation_lower = red_girl_hsv[:, :, 1] > 80
    value_upper = red_girl_hsv[:, :, 2] < 90
    value_lower = red_girl_hsv[:, :, 2] > 40
    mask = upper_mask * lower_mask * saturation_upper * saturation_lower * value_upper * value_lower * value_lower
    red = red_girl[:, :, 0] * mask
    green = red_girl[:, :, 1] * mask
    blue = red_girl[:, :, 2] * mask
    brick_masked = np.dstack((red, green, blue))
    plt.figure(num=None, figsize=(8, 6), dpi=80)
    imshow(brick_masked)
    plt.savefig("brick_mask.jpg")
    #plt.show()

    lower_mask = red_girl_hsv[:, :, 0] > 200
    upper_mask = red_girl_hsv[:, :, 0] < 240
    saturation_upper = red_girl_hsv[:, :, 1] < 240
    saturation_lower = red_girl_hsv[:, :, 1] > 200
    value_upper = red_girl_hsv[:, :, 2] < 240
    value_lower = red_girl_hsv[:, :, 2] > 200
    mask = upper_mask * lower_mask * saturation_upper * saturation_lower * value_upper * value_lower * value_lower
    red = red_girl[:, :, 0] * mask
    green = red_girl[:, :, 1] * mask
    blue = red_girl[:, :, 2] * mask
    numbers_masked = np.dstack((red, green, blue))
    plt.figure(num=None, figsize=(8, 6), dpi=80)
    imshow(numbers_masked)
    plt.savefig("numbers_mask.jpg")
    #plt.show()

def compare_number(test, num, debug=False):
    compare_num = imread(str(num) + "_number.jpg")
    test = test.astype(np.int16)
    compare_num = compare_num.astype(np.int16)
    count = 0
    for i in range(len(test)):
        for j in range(len(test[i])):
            """print(test[i][j])
            print(compare_num[i][j])
            print(test[i][j] - compare_num[i][j])
            print((test[i][j] - compare_num[i][j])**2)
            print(sum((test[i][j] - compare_num[i][j])**2))
            print(sum((test[i][j] - compare_num[i][j])**2)**0.5)
            print()"""
            #print(test[i][j])
            #print(compare_num[i][j])
            val = abs(sum((test[i][j] - compare_num[i][j])**2))**0.5
            #print(val)
            #print()
            if val < 100:
                count += 1
                compare_num[i][j] = [0, 255, 0]
        #print("_________________________")
        #quit()
    #plt.figure(num=None, figsize=(8, 6), dpi=80)
    #imshow(compare_num)
    #plt.show()
    #quit()
    return count / (25*25)

def compare_numbers(test):
    max_index = -1
    max_value = -1
    for i in [2, 3, 4, 5, 6, 8, 9, 10, 11, 12]:
        temp = compare_number(test, i)
        if temp > max_value:
            max_value = temp
            max_index = i
    return max_index


if __name__ == '__main__':
    #main()
    #files = ["brick_mask.jpg", "sheep_mask.jpg", "wheat_mask.jpg", "wood_mask.jpg", "ore_mask.jpg"]
    materials = ["brick", "sheep", "wheat", "wood", "ore"]
    material_locations = {}
    for material in materials:
        material_locations[material] = get_hex_locations(material + "_mask.jpg")

    offset1 = 1
    offset2 = 24
    offset3 = 12
    offset4 = 13

    numbers = imread("numbers_mask.jpg")

    material_locations2 = {"brick": [], "sheep": [], "wheat": [], "wood": [], "ore": []}

    for material in materials:
        print(material)
        for location in material_locations[material]:
            test_num = numbers[location[1] - offset1:location[1] + offset2, location[0] - offset3:location[0] + offset4, :]

            #plt.figure(num=None, figsize=(8, 6), dpi=80)
            #imshow(test_num)
            #plt.show()

            num = compare_numbers(test_num)
            material_locations2[material].append((num, location))
            #print("\t" + str(location))
            #quit()

    #quit()

    pprint(material_locations2)
