create view v_solicitud
as
select o.orden "numero",
	   t.entidad_id,
       o.fecha_registro,
       f.formato,
       e.entidad,
       t.estado,
       'O' etapa
from   tce t,
       orden o,
       formato f,
       entidad e
where  t.orden_id = o.orden_id
and    t.formato_id = f.formato_id
and    t.entidad_id = e.entidad_id
and    t.estado in ('A','B')
union all
select s.suce "numero",
	   t.entidad_id,
       s.fecha_registro,
       f.formato,
       e.entidad,
       t.estado,
       'S' etapa
from   tce t,
       suce s,
       formato f,
       entidad e
where  t.suce_id = s.suce_id
and    t.formato_id = f.formato_id
and    t.entidad_id = e.entidad_id
and    t.estado in ('C','D')
union all
select d.dr "numero",
	   t.entidad_id,
       d.fecha_registro,
       f.formato,
       e.entidad,
       t.estado,
       'D' etapa
from   tce t,
       dr d,
       suce s,
       formato f,
       entidad e
where  t.suce_id = s.suce_id
and    s.suce_id = d.suce_id
and    t.formato_id = f.formato_id
and    t.entidad_id = e.entidad_id
and    t.estado in ('E','F');