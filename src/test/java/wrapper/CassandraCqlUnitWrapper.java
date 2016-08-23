package wrapper;

import org.cassandraunit.CassandraCQLUnit;
import org.cassandraunit.dataset.CQLDataSet;

public class CassandraCqlUnitWrapper extends CassandraCQLUnit {
    public CassandraCqlUnitWrapper(CQLDataSet dataSet) {
        super(dataSet);
    }

    @Override
    public void load() {
        super.load();
    }
}
