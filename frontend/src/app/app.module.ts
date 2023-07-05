import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {CabecalhoComponent} from './meat/componentes/cabecalho/cabecalho.component';
import {LoginComponent} from './meat/paginas/seguranca/usuario/login/login.component';
import {NgOptimizedImage} from "@angular/common";
import {InputTextModule} from "primeng/inputtext";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {CheckboxModule} from "primeng/checkbox";
import {ButtonModule} from "primeng/button";
import {CadastroComponent} from './meat/paginas/seguranca/usuario/cadastro/cadastro.component';
import {PaginaInicialComponent} from './meat/paginas/pagina-inicial/pagina-inicial.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MessagesModule} from "primeng/messages";
import {HttpClientModule} from "@angular/common/http";
import {UsuarioService} from "./meat/servicos/usuario.service";
import {MensagemService} from "./meat/servicos/mensagem.service";
import {MessageService} from "primeng/api";

@NgModule({
    declarations: [
        AppComponent,
        CabecalhoComponent,
        LoginComponent,
        CadastroComponent,
        PaginaInicialComponent
    ],
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        AppRoutingModule,
        NgOptimizedImage,
        InputTextModule,
        HttpClientModule,
        CheckboxModule,
        ButtonModule,
        ReactiveFormsModule,
        MessagesModule,
        FormsModule
    ],
    providers: [UsuarioService, MensagemService, MessageService],
    bootstrap: [AppComponent]
})
export class AppModule {
}
