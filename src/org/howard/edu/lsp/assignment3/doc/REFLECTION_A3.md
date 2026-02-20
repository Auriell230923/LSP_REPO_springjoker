# CSCI 363 – Assignment 3 Reflection (Object-Oriented Redesign)

## Overview

In Assignment 2, I built an ETL pipeline in Java that reads from `data/products.csv`, transforms the data, and writes to `data/transformed_products.csv`. The program worked correctly, but the design was more procedural. Most of the logic for reading, validating, transforming, and writing was grouped together, which made the code harder to organize and modify.

For Assignment 3, I redesigned the same program to be more object-oriented. I kept the exact same functionality (same input path, same output path, same transformations, and same error handling), but I reorganized the code into multiple classes with clearer responsibilities.

---

## What is different about the design?

### Assignment 2

In Assignment 2, the program followed the ETL steps in one main flow:
- Read the file  
- Validate each row  
- Transform the data  
- Write the output  

Most of this logic was connected in one place. While it worked, the responsibilities were mixed together. For example, validation logic and transformation logic were closely tied to file reading and writing.

### Assignment 3

In Assignment 3, I broke the solution into multiple classes, each responsible for one specific task:

- `CsvFileReader` – reads the input file
- `CsvRow` – represents a raw CSV row
- `ProductRowParser` – validates and converts a row into a product object
- `ProductRecord` – represents a product as an object
- `ProductTransformer` – applies transformations (uppercase name, price rounding, price range)
- `CsvFileWriter` – writes the output file
- `ETLPipeline` – coordinates the overall ETL process
- `ETLPipelineApp` – contains the `main()` method

This structure makes the program easier to read and understand because each class has one clear responsibility.

---

## How is Assignment 3 more object-oriented?

Assignment 3 is more object-oriented because the program is built around objects instead of just steps. Instead of passing around raw strings and arrays, I created a `ProductRecord` class to represent product data. Each part of the ETL process is handled by a specific object.

The pipeline now works by having objects collaborate:
- The reader extracts data.
- The parser validates and converts it.
- The transformer modifies it.
- The writer outputs it.

This separation makes the code cleaner and more organized.

---

## Object-Oriented Concepts Used

### Objects and Classes
The program uses multiple classes to represent different responsibilities. Each class is instantiated as an object and plays a role in the ETL process.

### Encapsulation
Encapsulation is shown by grouping related data and behavior together.
For example:
- `ProductRecord` stores product information and includes a method to format it correctly for CSV output.
- File reading and writing logic are contained inside their own classes instead of being mixed into the pipeline logic.

### Inheritance
I used inheritance with `AbstractRowParser<T>`, which defines a general structure for parsing rows.  
`ProductRowParser` extends this base class and implements the specific validation and conversion logic for products.

### Polymorphism
I used interfaces to demonstrate polymorphism:
- `Transformer<I, O>` allows different transformation implementations.
- `PriceRangeClassifier` allows different price classification strategies.

The `ETLPipeline` depends on these interfaces rather than specific implementations, which makes the design more flexible.

---

## How I Tested That Assignment 3 Matches Assignment 2

To make sure Assignment 3 behaves exactly like Assignment 2, I tested several cases:

1. **Normal input file**
   - Confirmed the output file is created.
   - Verified the header is correct.
   - Checked that:
     - Product names are uppercase
     - Prices are rounded to two decimal places
     - PriceRange is correctly added

2. **Invalid rows**
   - Tested rows with:
     - Non-integer ProductID
     - Non-numeric price
     - Wrong number of columns
     - Missing values
   - Confirmed these rows were skipped.

3. **Missing input file**
   - Temporarily removed the input file.
   - Confirmed the program prints an error and does not crash.

4. **Empty file / header-only file**
   - Confirmed the output file is still created with just the header.

These tests confirmed that Assignment 3 produces the same results as Assignment 2 while improving the internal design using object-oriented principles.