# **Text Processing and Data Management Tool**

### **Overview**
The Text Processing and Data Management Tool is a robust Java application built using modern design patterns and best practices. It provides:
- Advanced text manipulation through regular expressions (regex).
- Efficient data handling using Java collections (`ArrayList`, `Set`, `Map`).
- A user-friendly graphical interface developed with JavaFX for seamless interaction.

The project adheres to principles like **SOLID**, **DRY**, and **Separation of Concerns (SoC)**, ensuring scalability and maintainability.

---

### **Features**
#### **1. Regular Expressions (Regex) Module**
- Search, match, and replace text using powerful regex patterns.
- Supports advanced constructs such as sets, ranges, alternations, shorthand classes, and quantifiers.
- Fully interactive UI for user input and result visualization.

#### **2. Text Processing Module**
- Utilize Java’s `Pattern` and `Matcher` classes for regex operations.
- Process large datasets efficiently and preview transformations in real-time.

#### **3. Data Management Module**
- Perform CRUD operations on collections (`ArrayList`, `Set`, `Map`).
- Implements `hashCode` and `equals` methods for custom object handling in collections.
- View and manage collections dynamically through the UI.

#### **4. User Interface**
- Built with **JavaFX**, incorporating clean and responsive design.
- Tabs and sections for Regex, Text Processing, and Data Management for modularity.
- Comprehensive error handling to guide users.

---

### **Technology Stack**
- **Language**: Java (JDK 21 LTS)
- **Framework**: JavaFX
- **Design Patterns**:
    - **Factory Pattern**: To instantiate complex objects.
    - **Observer Pattern**: For real-time UI updates on collection changes.
    - **MVC (Model-View-Controller)**: For clear separation of application logic and UI.
- **Libraries/Tools**:
    - JavaFX SceneBuilder for UI development.
    - `Pattern` and `Matcher` for regex handling.
    - Maven/Gradle for build automation.

---

### **Installation and Setup**

#### **1. Prerequisites**
- JDK 21 (LTS) installed.
- JavaFX SDK installed.
- Maven or Gradle installed for dependency management.

#### **2. Clone the Repository**
```bash
git clone https://github.com/AbuduSamadu/test-processing.git
cd text-processing
