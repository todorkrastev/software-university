target_steps = 10000
steps_done = 0

while True:
    line = input()

    if line == "Going home":
        home_steps = int(input())
        steps_done = steps_done + home_steps
        if steps_done >= target_steps:
            print("Goal reached! Good job!")
            print(f"{steps_done - target_steps} steps over the goal!")
            break
        else:
            print(f"{target_steps - steps_done} more steps to reach goal.")
            break

    steps = int(line)
    steps_done += steps

    if steps_done >= target_steps:
        print("Goal reached! Good job!")
        print(f"{steps_done - target_steps} steps over the goal!")
        break

