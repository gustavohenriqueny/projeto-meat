import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CabecalhoComponent } from './meat/componentes/cabecalho/cabecalho.component';
import { LoginComponent } from './meat/seguranca/usuario/login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    CabecalhoComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
