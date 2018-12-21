package org.neo4j.kernel;
import org.neo4j.io.pagecache.tracing.cursor.context.VersionContextSupplier;
import org.neo4j.kernel.impl.transaction.log.files.LogFiles;
import org.neo4j.storageengine.api.StorageEngine;
import org.neo4j.kernel.impl.transaction.log.TransactionIdStore;

public class CoreBuildStore {
    private TransactionIdStore transactionIdStore;
    private StorageEngine storageEngine;
    private LogFiles logFiles;
    private VersionContextSupplier versionContextSupplier;

    public CoreBuildStore(TransactionIdStore transactionIdStore, StorageEngine storageEngine,
                          LogFiles logFiles, VersionContextSupplier versionContextSupplier) {
        this.transactionIdStore = transactionIdStore;
        this.storageEngine = storageEngine;
        this.logFiles = logFiles;
        this.versionContextSupplier = versionContextSupplier;
    }

    public TransactionIdStore getTransactionIdStore() {
        return transactionIdStore;
    }

    public StorageEngine getStorageEngine() {
        return storageEngine;
    }

    public LogFiles getLogFiles() {
        return logFiles;
    }

    public void setTransactionIdStore( TransactionIdStore transactionIdStore ) {
        this.transactionIdStore = transactionIdStore;
    }

    public void setStorageEngine( StorageEngine storageEngine ) {
        this.storageEngine = storageEngine;
    }

    public void setLogFiles( LogFiles logFiles ) {
        this.logFiles = logFiles;
    }

    public void initializeVersionContextSupplier() {
        versionContextSupplier.init( transactionIdStore::getLastClosedTransactionId );
    }
}
