import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CabecalhoComponent } from './meat/componentes/cabecalho/cabecalho.component';
import { LoginComponent } from './meat/seguranca/usuario/login/login.component';
import {NgOptimizedImage} from "@angular/common";
import {InputTextModule} from "primeng/inputtext";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {CheckboxModule} from "primeng/checkbox";
import {ButtonModule} from "primeng/button";

@NgModule({
  declarations: [
    AppComponent,
    CabecalhoComponent,
    LoginComponent
  ],
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        AppRoutingModule,
        NgOptimizedImage,
        InputTextModule,
        CheckboxModule,
        ButtonModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
