java -jar selenium-server-standalone-2.53.1.jar -role webdriver -hub http://localhost:2500/grid/register -port 5559 -browser browserName=chrome,maxInstances=4,version=chrome -Dwebdriver.chrome.driver=drivers\chromedriver.exe
