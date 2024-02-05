const puppeteer = require('puppeteer');

async function takeScreenshot() {
  const browser = await puppeteer.launch();
  const page = await browser.newPage();

  try {
    await page.goto('https://sonarcloud.io/summary/overall?id=dev-madhurendra_short-my-url-frontend', {
      waitUntil: 'networkidle0',
      timeout: 60000,
    });

    await page.screenshot({ path: '../coverage/FE-SONAR-COVERAGE.png', fullPage: true });
  } catch (error) {
    console.error('Error during navigation:', error);
  } finally {
    await browser.close();
  }
}

takeScreenshot();
