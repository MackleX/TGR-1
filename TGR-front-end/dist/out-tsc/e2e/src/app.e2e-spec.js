import { AppPage } from './app.po';
describe('workspace-project App', function () {
    var page;
    beforeEach(function () {
        page = new AppPage();
    });
    it('should display welcome message', function () {
        page.navigateTo();
        expect(page.getParagraphText()).toEqual('Welcome to argon-design-system-angular!');
    });
});
//# sourceMappingURL=app.e2e-spec.js.map