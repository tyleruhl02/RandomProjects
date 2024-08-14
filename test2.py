import matplotlib.pyplot as plt
import numpy as np

# Create a gradient array
gradient = np.linspace(0, 1, 256).reshape(1, -1)

# List of colormaps to display
cmaps = ['viridis', 'plasma', 'inferno', 'magma', 'cividis',
         'coolwarm', 'RdBu', 'PuOr',
         'tab10', 'tab20', 'Set1', 'Set2', 'Set3',
         'pink', 'spring', 'summer', 'autumn', 'winter']

# Plotting
fig, axs = plt.subplots(nrows=len(cmaps), figsize=(6, 12))
for ax, cmap in zip(axs, cmaps):
    ax.imshow(gradient, aspect='auto', cmap=cmap)
    ax.text(270, 128, cmap, fontsize=10, va='center')
    ax.set_axis_off()

plt.tight_layout()
plt.show()