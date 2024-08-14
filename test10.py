from PIL import Image
import numpy as np
im = Image.open('IMG_9954.jpg')

def avg(pixels, i, j, size=50):
    #r_sum = 0
    #g_sum = 0
    #b_sum = 0
    #count = 0

    my_dict = {}

    for i2 in range(i - size, i + size, 1):
        for j2 in range(j - size, j + size, 1):
            if ((i-i2)**2 + (j-j2)**2)**0.5 > size:
                continue
            try:
                key = str(pixels[i2][j2][0]) + "," + str(pixels[i2][j2][1]) + "," + str(pixels[i2][j2][2])
                if key not in my_dict.keys():
                    my_dict[key] = 1
                else:
                    my_dict[key] += 1
                #r_sum += pixels[i2][j2][0]
                #g_sum += pixels[i2][j2][1]
                #b_sum += pixels[i2][j2][2]
                #count += 1
            except Exception as e:
                continue

    max_val = 0
    max_key = None
    for key in my_dict.keys():
        if my_dict[key] > max_val:
            max_val = my_dict[key]
            max_key = key

    pixel = str(max_key).split(",")
    pixel[0] = int(pixel[0])
    pixel[1] = int(pixel[1])
    pixel[2] = int(pixel[2])
    return pixel

    #return (int(r_sum / count), int(g_sum / count), int(b_sum / count))

pixels = list(im.getdata())
width, height = im.size
pixels = [pixels[i * width:(i + 1) * width] for i in range(height)]

new_pixels = []

print(len(pixels))

for i in range(len(pixels)):
    new_pixels.append([])
    for j in range(len(pixels[i])):
        new_pixels[i].append(avg(pixels, i, j, 50))
    print(i)

array = np.array(new_pixels, dtype=np.uint8)

# Use PIL to create an image from the new array of pixels
new_image = Image.fromarray(array)
new_image.save('new2.png')