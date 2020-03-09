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
            if (pageData.hasAttribute("Test"))
                includeSetups();

            buffer.append(pageData.getContent());
            if (pageData.hasAttribute("Test"))
                includeTeardowns();

            pageData.setContent(buffer.toString());
            return pageData.getHtml();
        }

        private void includeSetups() throws Exception {
            if (includeSuiteSetup)
                includeIfInherited("setup", SuiteResponder.SUITE_SETUP_NAME);
            includeIfInherited("setup", "SetUp");
        }

        private void includeTeardowns() throws Exception {
            includeIfInherited("teardown", "TearDown");
            if (includeSuiteSetup)
                includeIfInherited("teardown", SuiteResponder.SUITE_TEARDOWN_NAME);
        }

        private void includeIfInherited(String mode, String pageName) throws Exception {
            WikiPage page = PageCrawlerImpl.getInheritedPage(pageName, wikiPage);
            if (page != null)
                buffer.append(includePage(mode, page));
        }

        private String includePage(String mode, WikiPage page) throws Exception {
            WikiPagePath pagePath = pageCrawler.getFullPath(page);
            String pagePathName = PathParser.render(pagePath);
            return String.format("!include -%s .%s%n", mode, pagePathName);
        }
    }
}
