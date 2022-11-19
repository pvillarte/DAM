from random import random
from multiprocessing import Pool
import time
import os

#Create a pool of workers to run parallel tasks.
#The pool size should be the number of CPU cores available on your node minus 1 (8cores > pool of 7 workers).
#Write a function to be running in parallel, call it my_id. The function should receive as input the task id.
#When called, the function will print to the screen a message in the form: “Hi, I’m worker ID (with PID)”
#Where ID should be replaced with the task number assigned to the worker and PID with the process ID of the running worker.
#Run tasks in parallel using the map function, for a total of tasks equal to twice the number of CPU cores in your node.

NUM_PROCESOS = 5 #Mi procesador tiene 8, por tanto nProcesos = (nCores-1)

def my_id(task_id):
    print(f"start process:{task_id}")
    ID = task_id
    PID = os.getpid()
    print(f"Hi, I'm worker {ID} (with {PID})")
    time.sleep(0.3)


if __name__ == "__main__":
    starttime = time.time()
    pool = Pool(NUM_PROCESOS)
    pool.map(my_id, range(0, 100))
    pool.close()
    endtime = time.time()
    print(f"Time taken {endtime-starttime} seconds")

