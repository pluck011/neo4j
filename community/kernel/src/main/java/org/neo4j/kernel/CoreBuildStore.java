package org.neo4j.kernel;
import org.neo4j.kernel.impl.transaction.log.files.LogFiles;
import org.neo4j.storageengine.api.StorageEngine;
import org.neo4j.kernel.impl.transaction.log.TransactionIdStore;

public class CoreBuildStore {
    private TransactionIdStore transactionIdStore;
    private StorageEngine storageEngine;
    private LogFiles logFiles;

    public CoreBuildStore( TransactionIdStore transactionIdStore, StorageEngine storageEngine, LogFiles logFiles ) {
        this.transactionIdStore = transactionIdStore;
        this.storageEngine = storageEngine;
        this.logFiles = logFiles;
    }

    public CoreBuildStore() {}

    public TransactionIdStore getTransactionIdStore() {
        return transactionIdStore;
    }

    public StorageEngine getStorageEngine() {
        return storageEngine;
    }

    public LogFiles getLogFiles() {
        return logFiles;
    }

    public void setTransactionIdStore(TransactionIdStore transactionIdStore) {
        this.transactionIdStore = transactionIdStore;
    }
}
