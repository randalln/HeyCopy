databaseChangeLog = {

	changeSet(author: "rnorviel (generated)", id: "1394556125810-1") {
		createTable(tableName: "setting") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "settingPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "k", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "v", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}
}
