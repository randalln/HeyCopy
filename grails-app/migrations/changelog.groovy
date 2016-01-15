databaseChangeLog = {

	changeSet(author: "rnorviel (generated)", id: "1394484840938-1") {
		createTable(tableName: "admin") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "adminPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rnorviel (generated)", id: "1394484840938-2") {
		createTable(tableName: "hwstring") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "hwstringPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "a_order", type: "integer") {
				constraints(nullable: "false")
			}

			column(name: "comments", type: "varchar(512)")

			column(name: "copy", type: "varchar(512)") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "group_by", type: "varchar(255)")

			column(name: "label", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "platform_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "product_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "string_array_id", type: "bigint")
		}
	}

	changeSet(author: "rnorviel (generated)", id: "1394484840938-3") {
		createTable(tableName: "platform") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "platformPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rnorviel (generated)", id: "1394484840938-4") {
		createTable(tableName: "product") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "productPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rnorviel (generated)", id: "1394484840938-5") {
		createTable(tableName: "string_array") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "string_arrayPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "platform_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "product_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rnorviel (generated)", id: "1394484840938-11") {
		createIndex(indexName: "FK955525E041AAA940", tableName: "hwstring") {
			column(name: "string_array_id")
		}
	}

	changeSet(author: "rnorviel (generated)", id: "1394484840938-12") {
		createIndex(indexName: "FK955525E0A7AB0A31", tableName: "hwstring") {
			column(name: "platform_id")
		}
	}

	changeSet(author: "rnorviel (generated)", id: "1394484840938-13") {
		createIndex(indexName: "FK955525E0D9913F23", tableName: "hwstring") {
			column(name: "product_id")
		}
	}

	changeSet(author: "rnorviel (generated)", id: "1394484840938-14") {
		createIndex(indexName: "unique_label", tableName: "hwstring", unique: "true") {
			column(name: "platform_id")

			column(name: "product_id")

			column(name: "label")
		}
	}

	changeSet(author: "rnorviel (generated)", id: "1394484840938-15") {
		createIndex(indexName: "name_uniq_1394484840931", tableName: "platform", unique: "true") {
			column(name: "name")
		}
	}

	changeSet(author: "rnorviel (generated)", id: "1394484840938-16") {
		createIndex(indexName: "name_uniq_1394484840932", tableName: "product", unique: "true") {
			column(name: "name")
		}
	}

	changeSet(author: "rnorviel (generated)", id: "1394484840938-17") {
		createIndex(indexName: "FK184024ABA7AB0A31", tableName: "string_array") {
			column(name: "platform_id")
		}
	}

	changeSet(author: "rnorviel (generated)", id: "1394484840938-18") {
		createIndex(indexName: "FK184024ABD9913F23", tableName: "string_array") {
			column(name: "product_id")
		}
	}

	changeSet(author: "rnorviel (generated)", id: "1394484840938-6") {
		addForeignKeyConstraint(baseColumnNames: "platform_id", baseTableName: "hwstring", constraintName: "FK955525E0A7AB0A31", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "platform", referencesUniqueColumn: "false")
	}

	changeSet(author: "rnorviel (generated)", id: "1394484840938-7") {
		addForeignKeyConstraint(baseColumnNames: "product_id", baseTableName: "hwstring", constraintName: "FK955525E0D9913F23", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "product", referencesUniqueColumn: "false")
	}

	changeSet(author: "rnorviel (generated)", id: "1394484840938-8") {
		addForeignKeyConstraint(baseColumnNames: "string_array_id", baseTableName: "hwstring", constraintName: "FK955525E041AAA940", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "string_array", referencesUniqueColumn: "false")
	}

	changeSet(author: "rnorviel (generated)", id: "1394484840938-9") {
		addForeignKeyConstraint(baseColumnNames: "platform_id", baseTableName: "string_array", constraintName: "FK184024ABA7AB0A31", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "platform", referencesUniqueColumn: "false")
	}

	changeSet(author: "rnorviel (generated)", id: "1394484840938-10") {
		addForeignKeyConstraint(baseColumnNames: "product_id", baseTableName: "string_array", constraintName: "FK184024ABD9913F23", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "product", referencesUniqueColumn: "false")
	}

	include file: 'd0b1f8f7751485073eceb9e59c93b5378fbbea5d.groovy'

	include file: 'setting-create.groovy'

	include file: 'setting-alter0.groovy'
}
