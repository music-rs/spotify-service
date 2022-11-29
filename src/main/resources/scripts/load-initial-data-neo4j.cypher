// load initial neo4j data
// Run it only once. ;)
// Have you run it twice? Use `MATCH (n) WHERE (n:User OR n:Artist OR n:Genre OR n:MusicEvent OR n:Location OR n:Organization) DETACH DELETE n` to start over.

CREATE (u_jit:User {name: 'Jhonatan', lastname: 'Ibañez', username: 'jit', password: 'jit', email: 'jhonatan.ibatac@gmail.com', descriptionUser: 'I am fond of all kind of music genre :)'})
CREATE (a_am:Artist {name: 'Arctic Monkeys'})
CREATE (a_interpol:Artist {name: 'Interpol'})
CREATE (a_zoe:Artist {name: 'Zoe'})
CREATE (a_caloncho:Artist {name: 'Caloncho'})
CREATE (a_enjambre:Artist {name: 'Enjambre'})
CREATE (a_cafres:Artist {name: 'Los Cafres'})
CREATE
  (u_jit)-[:FAN_OF]->(a_am),
  (u_jit)-[:FAN_OF]->(a_interpol),
  (u_jit)-[:FAN_OF]->(a_zoe),
  (u_jit)-[:FAN_OF]->(a_caloncho),
  (u_jit)-[:FAN_OF]->(a_enjambre),
  (u_jit)-[:FAN_OF]->(a_cafres)


CREATE (g_indierock:Genre {name: 'Indie rock'})
CREATE (g_reggae:Genre {name: 'Reggae'})
CREATE
  (u_jit)-[:LIKE]->(g_indierock),
  (u_jit)-[:LIKE]->(g_reggae)
CREATE
  (a_am)-[:BELONG_TO]->(g_indierock),
  (a_interpol)-[:BELONG_TO]->(g_indierock),
  (a_zoe)-[:BELONG_TO]->(g_indierock),
  (a_caloncho)-[:BELONG_TO]->(g_indierock),
  (a_enjambre)-[:BELONG_TO]->(g_indierock),
  (a_cafres)-[:BELONG_TO]->(g_reggae)


CREATE (me_am:MusicEvent {name: 'Arctic Monkeys & Interpol', description:'2 great bands in concert'})
CREATE (me_zoe:MusicEvent {name: 'Zoe & Caloncho', description:'2 great bands in concert'})
CREATE
  (u_jit)-[:INTERESTED_IN {interestedCount:0, visitedCount:0, evaluation:0}]->(me_am),
  (u_jit)-[:INTERESTED_IN {interestedCount:0, visitedCount:0, evaluation:0}]->(me_zoe)
CREATE
  (a_am)-[:GIVE]->(me_am),
  (a_interpol)-[:GIVE]->(me_am),
  (a_zoe)-[:GIVE]->(me_zoe),
  (a_caloncho)-[:GIVE]->(me_zoe)


CREATE (l_arena1:Location {name: 'Arena 1', address:'Av, Cto. de Playas S/N, San Miguel 15087', referenceAddress: 'Costa Verde', region: 'Lima'})
CREATE (l_arenaperu:Location {name: 'Arena Perú', address:'Av. Javier Prado Este 4406, Santiago de Surco 15023', referenceAddress: 'Jockey Plaza', region: 'Lima'})
CREATE
  (me_am)-[:LOCATED_IN]->(l_arenaperu),
  (me_zoe)-[:LOCATED_IN]->(l_arena1)


CREATE (o_move:Organization {name: 'Move Concerts'})
CREATE
  (me_am)-[:PRODUCED_BY]->(o_move),
  (me_zoe)-[:PRODUCED_BY]->(o_move)
