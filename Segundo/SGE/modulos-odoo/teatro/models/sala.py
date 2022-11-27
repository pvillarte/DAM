# -*- coding: utf-8 -*-

from odoo import models, fields, api
from . import base

class sala(models.Model):
    _name = 'teatro.sala'
    _description = 'Permite definir las características de una sala'
    _inherit = 'teatro.base'

    name = fields.Char(string='Nombre sala')
    num_butacas = fields.Integer(string='Cantidad butacas')
    
    obra_ids = fields.One2many('teatro.obra', 'sala_id', string="Obras")

    duracion_obras = fields.Float(string='Suma de duración de obras asociadas', compute='_duracion_obras')


    @api.depends("obra_ids")
    def _duracion_obras(self):
        for record in self:
            if len(record.obra_ids) != 0:
                if len(record.obra_ids) > 1:
                    for obra in record.obra_ids:
                        record.duracion_obras += obra.duracion
                else:
                    record.duracion_obras = record.obra_ids.duracion
            else:
                record.duracion_obras = 0.0