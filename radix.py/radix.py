def counting_sort(arr, exp):
    n = len(arr)
    output = [0] * n  # output array
    count = [0] * 10  # for digits 0 to 9

    # Count occurrences of digits at current place (exp)
    for i in range(n):
        index = (arr[i] // exp) % 10
        count[index] += 1

    # Update count[i] so it contains the actual position of this digit in output
    for i in range(1, 10):
        count[i] += count[i - 1]

    # Build output array
    i = n - 1
    while i >= 0:
        index = (arr[i] // exp) % 10
        output[count[index] - 1] = arr[i]
        count[index] -= 1
        i -= 1

    # Copy sorted numbers back to original array
    for i in range(n):
        arr[i] = output[i]

def radix_sort(arr):
    # Find the maximum number to know the number of digits
    max_num = max(arr)

    # Apply counting sort for each digit (exp = 1, 10, 100, ...)
    exp = 1
    while max_num // exp > 0:
        counting_sort(arr, exp)
        exp *= 10

# Example usage
arr = [170, 45, 75, 90, 802, 24, 2, 66]
radix_sort(arr)
print("Sorted array:", arr)
