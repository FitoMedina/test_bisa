package com.bisa.test.data;


import com.bisa.test.app.client.api.ListClients;
import com.bisa.test.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>, JpaSpecificationExecutor<Client> {
    @Query(
            value = "SELECT c.id as id, SUM(r.id)  as total, (CASE WHEN SUM(r.id) < 1 THEN 'NULA' WHEN SUM(r.id) < 2 THEN 'MALA' WHEN SUM(r.id) < 3 THEN 'REGULAR' ELSE 'BUENA' END) as access FROM client as c RIGHT JOIN reference as r on c.id = r.client_id group by (c.id) ORDER BY total DESC",
            nativeQuery = true
    )
    List<ListClients> getOneShotTransactionsByOneShotIdList();
}
