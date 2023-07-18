import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from "./meat/paginas/seguranca/usuario/login/login.component";
import {CadastroComponent} from "./meat/paginas/seguranca/usuario/cadastro/cadastro.component";
import {PaginaInicialComponent} from "./meat/paginas/pagina-inicial/pagina-inicial.component";
import {RestaurantesComponent} from "./meat/paginas/restaurantes/restaurantes.component";

const routes: Routes = [
    {path: '', component: PaginaInicialComponent},
    {path: 'login', component: LoginComponent},
    {path: 'cadastrar', component: CadastroComponent},
    {path: 'restaurantes', component: RestaurantesComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
