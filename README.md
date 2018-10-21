[![Price](https://img.shields.io/badge/price-FREE-0098f7.svg)](https://github.com/mkowsiak/ProfilerCode/blob/master/LICENSE.md)
[![GitHub](https://img.shields.io/github/license/mashape/apistatus.svg)](https://github.com/mkowsiak/ProfilerCode/blob/master/LICENSE.md)
# NetBeans - Profiler testing code

Very simple, Java based, code for testing profiler. This code spawns 2-4 threads, each of threads sleeps for 5-10 seconds and allocates memory in range from 512KB to 512MB. It's super simple code. Nothing fancy, really. BTW - all the values are geneated randomly in each loop.

# Project structure

    .
    |-- LICENSE.md                             - MIT license file
    |-- README.md                              - this README.md file
    `-- Main.java                              - simple Java code

# Building

    > git clone https://github.com/mkowsiak/ProfilerCode
    > cd ProfilerCode
    > javac Main.java

# Running

    > java -cp . Main

# Known limitations

There are lots of constants burried down inside the code. I don't quite care about that because purpose of the code is just to run forever and do some stuff with threads and memory.

There is no package or whatsoever, and I don't care as well. This code is made of two clasess and serves it's purpose.

# References

This code is quite useless without <a href="https://github.com/mkowsiak/ProfilerDocker">ProfilerDocker</a>.
