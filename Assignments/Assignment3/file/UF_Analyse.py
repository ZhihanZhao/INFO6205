import matplotlib.pyplot as plt
from matplotlib.pyplot import MultipleLocator

with open('F:\\Assignment3\\file\\M.txt') as f:
    M = f.read()
M = M.split("\t")[0:2969]

with open('F:\\Assignment3\\file\\N.txt') as f:
    N = f.read()
N = N.split("\t")[0:2969]

plt.title("Relationship between N and M")
plt.scatter(N, M, c="#ff1212", marker=".")
y_major_locator=MultipleLocator(2000)
x_major_locator=MultipleLocator(400)
plt.xlabel("the number of objects")
plt.ylabel("the number of pairs")
ax=plt.gca()
ax.xaxis.set_major_locator(x_major_locator)
ax.yaxis.set_major_locator(y_major_locator)
plt.show()

