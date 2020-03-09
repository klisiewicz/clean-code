package com.cleancoders.html;

import fitnesse.responders.run.SuiteResponder;
import fitnesse.wiki.*;

public class TestableHtml {

    public String testableHtml(PageData pageData, boolean includeSuiteSetup) throws Exception {
        return new TestableHtmlMaker(pageData, includeSuiteSetup).invoke();
    }

    private static class TestableHtmlMaker {
        private PageData pageData;
        private boolean includeSuiteSetup;
        private WikiPage wikiPage;
        private StringBuffer buffer;
        private PageCrawler pageCrawler;

        public TestableHtmlMaker(PageData pageData, boolean includeSuiteSetup) {
            this.pageData = pageData;
            this.includeSuiteSetup = includeSuiteSetup;
            wikiPage = pageData.getWikiPage();
            buffer = new StringBuffer();
            pageCrawler = wikiPage.getPageCrawler();
        }

        public String invoke() throws Exception {
            if (pageData.hasAttribute("Test")) {
                String mode = "setup";
                if (includeSuiteSetup) {
                    WikiPage suiteSetup = PageCrawlerImpl.getInheritedPage(SuiteResponder.SUITE_SETUP_NAME, wikiPage);
                    if (suiteSetup != null)
                        includePage(mode, suiteSetup);
                }
                WikiPage setup = PageCrawlerImpl.getInheritedPage("SetUp", wikiPage);
                if (setup != null)
                    includePage(mode, setup);
            }

            buffer.append(pageData.getContent());
            if (pageData.hasAttribute("Test")) {
                WikiPage teardown = PageCrawlerImpl.getInheritedPage("TearDown", wikiPage);
                String mode = "teardown";
                if (teardown != null)
                    includePage(mode, teardown);
                if (includeSuiteSetup) {
                    WikiPage suiteTeardown = PageCrawlerImpl.getInheritedPage(SuiteResponder.SUITE_TEARDOWN_NAME, wikiPage);
                    if (suiteTeardown != null)
                        includePage(mode, suiteTeardown);
                }
            }

            pageData.setContent(buffer.toString());
            return pageData.getHtml();
        }

        private void includePage(String mode, WikiPage page) throws Exception {
            WikiPagePath pagePath = pageCrawler.getFullPath(page);
            String pagePathName = PathParser.render(pagePath);
            buffer.append(String.format("!include -%s .%s%n", mode, pagePathName));
        }
    }
}