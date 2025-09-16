# sba-workshop

## Overview
- This is a school workshop. Help teacher to create math test for student, they can choose to upload there test into the test-bank in the system.
  
## Tech Stack
- FE: ReactJS, Typescripts, Vite, Tailwindcss
- BE: SpringBoot
- DB: MySQl, MongoDB

## Implementation
> Remember to run commands step by step
### Front-End
Follow the path to the [/workshop-fe](), then use the bellow command to install dependencies and run project locally.

```bash
npm install
npm run dev
```

### Back-End
Follow the path to the [/workshop-be-sql]() or [/workshop-be-nosql](), then use the bellow command to run project locally.

```bash
mvn spring-boot:run
```
## Build and Run
> Remember to run commands step by step
### Front-End
Follow the path to the [/workshop-fe](), then use the bellow command to install dependencies and run project through the built version.

```bash
npm install
npm run build
serve -s dist
```
Install the [@react-router/serve](https://www.npmjs.com/package/@react-router/serve) dependency if not installed, and run the project.
```
npm install @react-router/serve
serve -s dist
```
### Back-End
Follow the path to the [/workshop-be-sql]() or [/workshop-be-nosql](), then use the bellow command to run project locally. Replace the [file_name]() by your actual project file name after build.

```bash
mvn clean package
java -jar /target/file_name.jar
```
