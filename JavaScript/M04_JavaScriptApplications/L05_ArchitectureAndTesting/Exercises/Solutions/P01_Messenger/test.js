const { chromium } = require('playwright-chromium');
const { expect } = require('chai');

let browser, page;

describe('E2E tests', function () {
    this.timeout(6000);

    before(async () => { browser = await chromium.launch({ headless: false, slowMo: 500 }); });

    after(async () => { await browser.close(); });

    beforeEach(async () => { page = await browser.newPage(); });

    afterEach(async () => { await page.close(); });

    it('makes a screenshot of the homepage', async () => {
        await page.goto('http://localhost:5500');
        await page.screenshot({ path: 'homepage.png' });
    });

    it('loads all the available messages', async () => {
        await page.goto('http://localhost:5500');

        const response = await Promise.all([
            page.click('text=Refresh'),
            page.waitForRequest('**/jsonstore/messenger')
        ]);

        const content = await page.$eval('textarea[id="messages"]', (m) => m.value);
        expect(content).to.contains(`Spami: Hello, are you there?`);
        expect(content).to.contains(`Garry: Yep, whats up :?`);
        expect(content).to.contains(`Spami: How are you? Long time no see? :)`);
        expect(content).to.contains(`George: Hello, guys! :))`);
        expect(content).to.contains(`Spami: Hello, George nice to see you! :)))`);
    });

    it('sends a message', async () => {
        await page.goto('http://localhost:5500');
        await page.fill('#author', 'Günter');
        await page.fill('#content', 'Hallo!');
        await page.click('text=Send');
        await page.click('text=Refresh');

        const content = await page.$eval('textarea[id="messages"]', (m) => m.value);
        expect(content).to.contains('User: message');
    });
});
