How to run project locally
1. Import project as Maven project
2. Install mvn
3. Go to project folder using command line
4. run following command : mvn clean test

How to setup browser
- This project uses chromedriver for chrome version 83
- If browser version is different then do following steps
  1. Download chromerdriver from https://chromedriver.chromium.org/downloads
  2. replace chromedriver.exe in BrowserDrivers with the downloaded chromedriver.exe


This project is for the following question
1. Visit ndtv website’s weather page and search for Bangalore 
2. Store weather object 1 w.r.t this Bangalore (e.g. temp value as 33 degree celsius, 
humidity level as 70% etc.) 
3. Get response from the weather API for Bangalore 
4. Store the API response and build the weather object 2 
5. Specify the variance logic - for e.g. 2 degree celsius for temperature & 10% for humidity 
6. Compare weather objects 1 and 2 along with the variance and mark tests as pass or fail based on comparator response


