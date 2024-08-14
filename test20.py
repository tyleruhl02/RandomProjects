import numpy as np
np.random.seed(123)
import matplotlib.pyplot as plt


from skopt.benchmarks import branin as _branin

def branin(x, noise_level = 0.):
    return _branin(x) + noise_level * np.random.randn()


from matplotlib.colors import LogNorm

def plot_branin():
    fig, ax = plt.subplots()

    x1_values = np.linspace(-5, 10, 100)
    x2_values = np.linspace(0, 15, 100)
    x_ax, y_ax = np.meshgrid(x1_values, x2_values)
    vals = np.c_[x_ax.ravel(), y_ax.ravel()]
    fx = np.reshape([branin(val) for val in vals], (100, 100))

    cm = ax.pcolormesh(x_ax, y_ax, fx, norm=LogNorm(vmin=fx.min(), vmax = fx.max()), cmap="viridis_r")

    minima = np.array([[-np.pi, 12.275], [+np.pi, 2.275], [+np.pi*3, 2.475]])
    ax.plot(minima[:, 0], minima[:, 1], 'r.', markersize=14, lw=0, label="Minima")

    cb = fig.colorbar(cm)
    cb.set_label("f(x)")

    ax.legend(loc="best", numpoints=1)

    ax.set_xlabel("X1")
    ax.set_xlim([-5, 10])
    ax.set_ylabel("X2")
    ax.set_ylim([0, 15])

plot_branin()


from functools import partial
from skopt import gp_minimize, gbrt_minimize, forest_minimize, dummy_minimize

func = partial(branin, noise_level = 2.0)
bounds = [(-5.0, 10.), (0.0, 15.0)]
n_calls = 10


def run(minimizer, n_iter=5):
    return [minimizer(func, bounds, n_calls=n_calls, random_state=n) for n in range(n_iter)]

dummy_res = run(dummy_minimize)

print("DUMMY DONE")

gp_res = run(gp_minimize)

print("GP DONE")

rf_res = run(partial(forest_minimize, base_estimator="RF"))

print("RF DONE")

et_res = run(partial(forest_minimize, base_estimator="ET"))

print("ET DONE")

gbrt_res = run(gbrt_minimize)

print("GBRT DONE")


from skopt.plots import plot_convergence

plot = plot_convergence(("dummy_minimize", dummy_res), ("gp_minimize", gp_res), ("forest_minimize(rf)", rf_res), ("forest_minimize(et)", et_res), ("gbrt_minimize", gbrt_res), true_minimum=0.397887, yscale="log")

plot.legend(loc="best", prop={'size': 6}, numpoints=1)

plt.show()