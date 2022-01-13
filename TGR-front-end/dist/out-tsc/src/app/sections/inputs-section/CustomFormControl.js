var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
import { FormControl } from "@angular/forms";
var CustomFormControl = /** @class */ (function (_super) {
    __extends(CustomFormControl, _super);
    function CustomFormControl() {
        var args = [];
        for (var _i = 0; _i < arguments.length; _i++) {
            args[_i] = arguments[_i];
        }
        return _super.apply(this, args) || this;
    }
    CustomFormControl.prototype.setSiteName = function (siteName) {
        this.siteName = siteName;
    };
    CustomFormControl.prototype.getSiteName = function () {
        return this.siteName;
    };
    CustomFormControl.prototype.setSiteDescription = function (siteDescription) {
        this.siteDescription = siteDescription;
    };
    CustomFormControl.prototype.getSiteDescription = function () {
        return this.siteDescription;
    };
    return CustomFormControl;
}(FormControl));
export { CustomFormControl };
//# sourceMappingURL=CustomFormControl.js.map