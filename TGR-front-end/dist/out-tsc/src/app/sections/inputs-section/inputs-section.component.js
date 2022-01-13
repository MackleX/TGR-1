var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
import { Component } from '@angular/core';
import { Validators } from '@angular/forms';
import { FormArray, FormControl, FormGroup } from '@angular/forms';
import { CustomFormControl } from './CustomFormControl';
var InputsSectionComponent = /** @class */ (function () {
    function InputsSectionComponent() {
        this.siteChoosed = false;
    }
    InputsSectionComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.userInputs = new FormArray([
            new FormGroup({
                descriptionText: new FormControl('', [Validators.required]),
                targetedSites: new FormArray(this.getAvailableSites())
            })
        ]);
        this.userInputs.controls[0].get('targetedSites').valueChanges.subscribe(function (selectedValue) {
            _this.siteChoosed = selectedValue.some(function (a) { return a == true; });
            debugger;
        });
        debugger;
    };
    InputsSectionComponent.prototype.getAvailableSites = function () {
        var formArray = [];
        formArray.push(this.createCustomForm(false, "amazon", "A greate e-commerce website check it if you want"));
        formArray.push(this.createCustomForm(false, "amazon", "A greate e-commerce website check it if you want"));
        return formArray;
    };
    InputsSectionComponent.prototype.createCustomForm = function (value, siteName, siteDescription) {
        var form = new CustomFormControl(value);
        form.setSiteName(siteName);
        form.setSiteDescription(siteDescription);
        return form;
    };
    InputsSectionComponent.prototype.onSubmit = function () {
        var selectedWebSites = this.userInputs.controls['0'].controls['targetedSites'].controls.filter(function (v) { return v.value; }).map(function (v) { return v.getSiteName(); });
        var descriptionText = this.userInputs.controls['0'].controls['descriptionText'].value;
        var wrapper = {
            WebSites: selectedWebSites,
            textDescription: descriptionText
        };
        console.log(wrapper);
    };
    InputsSectionComponent = __decorate([
        Component({
            selector: 'app-inputs-section',
            templateUrl: './inputs-section.component.html',
            styleUrls: ['./inputs-section.component.css']
        }),
        __metadata("design:paramtypes", [])
    ], InputsSectionComponent);
    return InputsSectionComponent;
}());
export { InputsSectionComponent };
//# sourceMappingURL=inputs-section.component.js.map