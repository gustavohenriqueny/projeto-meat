import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from "./meat/paginas/seguranca/usuario/login/login.component";
import {CadastroComponent} from "./meat/paginas/seguranca/usuario/cadastro/cadastro.component";
import {PaginaInicialComponent} from "./meat/paginas/pagina-inicial/pagina-inicial.component";

const routes: Routes = [
    {path: '', component: PaginaInicialComponent},
    {path: 'login', component: LoginComponent},
    {path: 'cadastro', component: CadastroComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
