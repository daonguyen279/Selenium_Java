# daonh-sele
1. How to run test in intellij
- Dowload java sdk
- In project structure -> set the module and sdk to java jdk that you dowloaded
- Config to run test: in run/configuration popup -> click + to add TestNG configuration + set orther attribute to the suitable value. 
2. How to run paralell
In run_test.xml file
- Adjust the value of thread-count to the value of test that you want to run
- Set the value of parallel -> classes
3. How to open allure report
- just need to run allure-serve.cmd file