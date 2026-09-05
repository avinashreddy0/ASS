# Placements Assignment - Polynomial Secret Reconstruction

## Problem

Given a set of points in JSON format, each `y` value is represented in a different numerical base.

The input contains:

* `n` — total number of points provided.
* `k` — minimum number of points required to determine the polynomial.
* `k = m + 1`, where `m` is the degree of the polynomial.

The objective is to determine the **constant coefficient** of the polynomial.

Since the constant coefficient is the value of the polynomial at `x = 0`, we calculate:

```text
f(0)
```

## Approach

1. Read the JSON input.
2. Read `n` and `k`.
3. Read the `x` values from the JSON keys.
4. Decode each `y` value using its specified base.
5. Use `k` points to reconstruct the polynomial using **Lagrange interpolation**.
6. Evaluate the polynomial at `x = 0`.
7. The resulting value is the constant coefficient.
8. For the second testcase, the available points are checked to identify the polynomial consistent with the provided data.

## Why BigInteger?

The input values can be much larger than Java's `long` data type.

Therefore, the solution uses:

```java
java.math.BigInteger
```

This allows the program to safely handle very large integers.

## Language

Java

## Project Structure

```text
placements-assignment/
│
├── Main.java
├── testcase1.json
└── README.md
```

## How to Run

Compile:

```bash
javac Main.java
```

Run:

```bash
java Main
```

The program reads:

```text
testcase1.json
```

from the project working directory.

## Test Case 1

Input:

```json
{
    "keys": {
        "n": 4,
        "k": 3
    },
    "1": {
        "base": "10",
        "value": "4"
    },
    "2": {
        "base": "2",
        "value": "111"
    },
    "3": {
        "base": "10",
        "value": "12"
    },
    "6": {
        "base": "4",
        "value": "213"
    }
}
```

Decoded points:

```text
(1, 4)
(2, 7)
(3, 12)
(6, 39)
```

The polynomial is:

```text
f(x) = x² + 3
```

Therefore:

```text
f(0) = 3
```

### Output

```text
3
```

## Test Case 2

The second testcase contains:

```text
n = 10
k = 7
```

The encoded values are converted from their respective bases and the polynomial is reconstructed using Lagrange interpolation.

### Output

```text
79836264049851
```

## Algorithm

The Lagrange interpolation formula used is:

```text
f(x) = Σ yi × Π ((x - xj) / (xi - xj))
```

Since we need the constant coefficient:

```text
x = 0
```

Therefore:

```text
f(0) = Σ yi × Π ((-xj) / (xi - xj))
```

The implementation performs these calculations using `BigInteger` to avoid overflow and floating-point precision issues.

## Expected Results

| Test Case   |           Output |
| ----------- | ---------------: |
| Test Case 1 |              `3` |
| Test Case 2 | `79836264049851` |

## Notes

* Python is not used.
* The solution uses Java.
* `BigInteger` is used for large numerical values.
* No floating-point arithmetic is used.
* The input values are decoded according to their specified bases.
