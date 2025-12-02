

[![Typing SVG](https://readme-typing-svg.herokuapp.com?font=Fira+Code&pause=1000&color=47EDF7&vCenter=true&width=450&height=30&lines=Study+Buddy+AI+%F0%9F%A4%96)](https://git.io/typing-svg)
### Overview
StudyBuddy AI is a full-stack application designed to enhance the learning process using Generative AI. The system allows students to upload educational content (PDFs, docs), which are indexed into a Vector Database. Users can interact with a Chatbot to ask context-aware questions and generate simulated exams. The platform also features a Data Analytics module that tracks student performance and provides personalized study recommendations based on weak areas.

### Key Features

- **Smart Document Ingestion:** Extracts and vectorizes text from unstructured files (PDFs) using Apache Tika.

- **RAG Chatbot:** Context-aware Q&A using Spring AI and OpenAI/Ollama integration.

- **Adaptive Quiz Generator:** Automatically creates questions based on uploaded content.

- **Performance Analytics:** Tracks user progress and suggests topics for review using data aggregation.

### Tech Stack 

**Backend:** Java 21, Spring Boot 3, Spring AI.

**Database:** PostgreSQL (with pgvector extension) for vector storage.

**Frontend:** Angular, TypeScript.

**Infrastructure:** Docker, Docker Compose.
