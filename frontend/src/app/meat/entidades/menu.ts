import {Restaurante} from "./restaurante";
import {MenuItem} from "./menu-Item";

export class Menu {
    id!: number;
    restaurante!: Restaurante;
    menuItems!: MenuItem[];
}