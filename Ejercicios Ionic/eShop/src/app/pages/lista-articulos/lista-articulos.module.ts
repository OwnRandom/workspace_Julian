import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ListaArticulosPageRoutingModule } from './lista-articulos-routing.module';

import { ListaArticulosPage } from './lista-articulos.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ListaArticulosPageRoutingModule
  ],
  declarations: [ListaArticulosPage]
})
export class ListaArticulosPageModule {}
