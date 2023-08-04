import {Menu} from "./menu";

export class MenuItem {
    id!: number;
    menu!: Menu;
    nome!: string;
    descricao!: string;
    preco!: number;
    caminhoImagem!: string;
}