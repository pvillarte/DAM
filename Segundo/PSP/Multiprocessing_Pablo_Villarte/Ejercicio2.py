from random import random
from multiprocessing import Pool
import time
import os


#Create a pool of workers to run parallel tasks.
#The pool size should be 2.
#Write a function to be running in parallel, call it print_cube. The function should receive as input a number [num]. When called, the function will print to the screen
#  a message in the form: “The cube of number [num] is [cube]”. Where [cube] should be replaced with the cube of the number received as input.
#Write a function to be running in parallel, call it print_square. The function should receive as input a number [num]. When called, the function will print to the screen
#  a message in the form: “The square of number [num] is [square]”. Where [square] should be replaced with the square of the number received as input.

NUM_PROCESOS = 2 

def print_cube(num):
    PID = os.getpid()
    for i in range(1,50):
        time.sleep(0.1)
        print(f"The cube of number {num} is {num*num*num} | Process:{PID} iteration nº{i}")

def print_square(num):
    PID = os.getpid()
    for i in range(1,50):
        time.sleep(0.01)
        print(f"The square of number {num} is {num*num} | Process:{PID} iteration nº{i}")

if __name__ == "__main__":
    starttime = time.time()
    pool = Pool(NUM_PROCESOS)
    a= pool.apply_async(print_square,(3,))
    b= pool.apply_async(print_cube, (2, ))
    pool.close()
    a.wait()
    b.wait()
    endtime = time.time()
    print(f"Time taken {endtime-starttime} seconds")

