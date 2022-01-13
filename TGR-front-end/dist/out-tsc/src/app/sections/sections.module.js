var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NouisliderModule } from 'ng2-nouislider';
import { JwBootstrapSwitchNg2Module } from 'jw-bootstrap-switch-ng2';
import { RouterModule } from '@angular/router';
import { SectionsComponent } from './sections.component';
import { ButtonsSectionComponent } from './buttons-section/buttons-section.component';
import { InputsSectionComponent } from './inputs-section/inputs-section.component';
import { CrsSectionComponent } from './crs-section/crs-section.component';
import { NavigationSectionComponent } from './navigation-section/navigation-section.component';
import { TabsSectionComponent } from './tabs-section/tabs-section.component';
import { AlertsSectionComponent } from './alerts-section/alerts-section.component';
import { TypographySectionComponent } from './typography-section/typography-section.component';
import { AngularSectionComponent } from './angular-section/angular-section.component';
import { NucleoSectionComponent } from './nucleo-section/nucleo-section.component';
import { VersionsSectionComponent } from './versions-section/versions-section.component';
import { NgbdModalComponent } from './modal/modal.component';
import { NgbdModalContent } from './modal/modal.component';
var SectionsModule = /** @class */ (function () {
    function SectionsModule() {
    }
    SectionsModule = __decorate([
        NgModule({
            declarations: [
                SectionsComponent,
                ButtonsSectionComponent,
                InputsSectionComponent,
                CrsSectionComponent,
                NavigationSectionComponent,
                TabsSectionComponent,
                AlertsSectionComponent,
                TypographySectionComponent,
                AngularSectionComponent,
                NucleoSectionComponent,
                VersionsSectionComponent,
                NgbdModalComponent,
                NgbdModalContent
            ],
            entryComponents: [NgbdModalContent],
            imports: [
                CommonModule,
                FormsModule,
                NgbModule,
                RouterModule,
                ReactiveFormsModule,
                FormsModule,
                NouisliderModule,
                JwBootstrapSwitchNg2Module
            ],
            exports: [SectionsComponent]
        })
    ], SectionsModule);
    return SectionsModule;
}());
export { SectionsModule };
//# sourceMappingURL=sections.module.js.map