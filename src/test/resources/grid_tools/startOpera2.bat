java -jar selenium-server-standalone-2.53.1.jar -role webdriver -hub http://localhost:2500/grid/register -browser browserName=chrome,maxInstances=4,version=opera -Dwebdriver.chrome.driver=src\test\resources\grid_tools\operadriver.exe -port 5557