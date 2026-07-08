# QuizApp

A console-based application designed for dynamic quiz management and learning.

## 📖 Overview
QuizApp is a lightweight, command-line utility tailored to handle custom quiz logic and specific study requirements not found in standard quiz applications. This project serves as a practical sandbox for mastering Java, focusing heavily on Clean Code, strict Object-Oriented Programming (OOP) principles, and proper software architecture.

## ✨ Key Features
*   **Custom Quiz Logic:** Designed to meet unique, tailored learning requirements.
*   **Flexible Question Structure:** Support for both single-choice and multiple-choice questions using secure type safety.
*   **Interactive CLI:** A straightforward, console-based user interface for taking quizzes.

## 🛠️ Tech Info
*   **Language:** Java (JDK 21)
*   **Interface:** CLI (Command Line Interface)
*   **Architecture:** Object-Oriented Design focusing on immutability and encapsulation.

## 🧠 Architecture & OOP Concepts Covered
Here is a breakdown of the software engineering concepts applied during the development of this project.

<details>
<summary><b>1. Type Safety & Enums (Click to expand)</b></summary>

*   **Concept:** Used `QuestionType` enum instead of a raw `String` for categorizing quiz questions.
*   **Why:** Prevents runtime errors caused by typos (e.g., `"single"` vs `"Single_Choice"`) and forces compile-time validation.
</details>

<details>
<summary><b>2. Immutability & Encapsulation (Click to expand)</b></summary>

*   **Concept:** Applied `private final` keywords to all fields in the `Question` class, exposed only via getters.
*   **Why:** Ensures that once a question is created, its state cannot be modified from the outside, making the data thread-safe and predictable.
</details>