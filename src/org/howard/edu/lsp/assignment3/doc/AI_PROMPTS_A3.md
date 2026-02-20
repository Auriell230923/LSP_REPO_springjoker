# AI Prompts – Assignment 3

For this assignment, I used a generative AI assistant to help brainstorm how to redesign my Assignment 2 ETL pipeline in a more object-oriented way. I reviewed all suggestions and adjusted the code to make sure it matches the exact Assignment 2 requirements.

---

## Prompt 1 – Redesigning the ETL pipeline

**Prompt:**  
I have a Java ETL pipeline from Assignment 2 that reads `data/products.csv` and writes `data/transformed_products.csv`. How can I redesign it to be more object-oriented while keeping the same behavior?

**AI Suggestion (summary):**  
Break the program into separate classes for reading, parsing, transforming, and writing. Use a domain class to represent a product.

**How I used it:**  
I created classes like `CsvFileReader`, `ProductRowParser`, `ProductTransformer`, `CsvFileWriter`, and `ProductRecord`. I also created an `ETLPipeline` class to coordinate everything.

---

## Prompt 2 – Demonstrating inheritance and polymorphism

**Prompt:**  
What is a simple way to show inheritance and polymorphism in this ETL redesign?

**AI Suggestion (summary):**  
Create a base parser class and extend it. Use interfaces for transformation and classification logic.

**How I used it:**  
I implemented `AbstractRowParser<T>` as a base class and had `ProductRowParser` extend it.  
I used interfaces (`Transformer` and `PriceRangeClassifier`) to demonstrate polymorphism.

---

## Prompt 3 – Writing Javadocs

**Prompt:**  
Can you help generate Javadocs for each class and public method?

**AI Suggestion (summary):**  
Provided draft documentation comments.

**How I used it:**  
I used the drafts as a starting point and edited them to accurately reflect what my code does.

---

## Prompt 4 – Testing strategy

**Prompt:**  
What tests should I run to make sure Assignment 3 works the same as Assignment 2?

**AI Suggestion (summary):**  
Test normal input, invalid rows, missing input file, and empty/header-only input.

**How I used it:**  
I ran those tests and documented them in my reflection file.