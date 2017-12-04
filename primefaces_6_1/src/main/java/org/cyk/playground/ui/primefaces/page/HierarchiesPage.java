package org.cyk.playground.ui.primefaces.page;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.playground.ui.primefaces.model.Locality;
import org.cyk.playground.ui.primefaces.model.LocalityType;
import org.cyk.utility.common.userinterface.collection.DataTable;
import org.cyk.utility.common.userinterface.container.window.Window;
import org.cyk.utility.common.userinterface.hierarchy.Hierarchy;

import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class HierarchiesPage extends Window implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Hierarchy tree,table,treeLocalityType,tableLocalityType,treeLocality,tableLocality;
	
	@Override
	protected void initialisation() {
		super.initialisation();
		getPropertiesMap().setTitle("Hierarchies");
		
		tree = createTree(Hierarchy.RenderType.TREE);
		tree.build();
		
		table = createTree(Hierarchy.RenderType.TABLE);
		//DataTable.Columns.add(table, "label1", "value");
		table.build();
		
		treeLocality = new Hierarchy();
		treeLocality.setRenderType(Hierarchy.RenderType.TREE);
		treeLocality.loadNodes(Locality.COLLECTION);
		treeLocality.build();
		
		tableLocality = new Hierarchy();
		tableLocality.setRenderType(Hierarchy.RenderType.TABLE);
		tableLocality.addColumnsByFieldNames("globalIdentifier.code","globalIdentifier.name");
		tableLocality.loadNodes(Locality.COLLECTION);
		tableLocality.build();
		
		treeLocalityType = new Hierarchy();
		treeLocalityType.setRenderType(Hierarchy.RenderType.TREE);
		treeLocalityType.loadNodes(LocalityType.COLLECTION);
		treeLocalityType.build();
		
		tableLocalityType = new Hierarchy();
		tableLocalityType.setRenderType(Hierarchy.RenderType.TABLE);
		tableLocalityType.addColumnsByFieldNames("globalIdentifier.code","globalIdentifier.name");
		tableLocalityType.loadNodes(LocalityType.COLLECTION);
		tableLocalityType.build();
	}
	
	private Hierarchy createTree(Hierarchy.RenderType renderType){
		Hierarchy tree = new Hierarchy();
		tree.setRenderType(renderType);
		tree.addColumnByFieldName("VALUE", DataTable.Column.CellValueSource.ROW_PROPERTIES_MAP);
		tree.addColumnByFieldName("STYLE_CLASS", DataTable.Column.CellValueSource.ROW_PROPERTIES_MAP);
		tree.addColumnByFieldName("CLASS", DataTable.Column.CellValueSource.ROW_PROPERTIES_MAP);
		tree.addNode("1")
			.addNode("1.1")
			.getParent().addNode("1.2")
			.getParent().addNode("1.3")
			;
		tree.addNode("2")
			.addNode("2.1")
			.getParent().addNode("2.2")
			.getParent().addNode("2.3")
			;
		tree.addNode("3")
			.addNode("3.1")
			.getParent().addNode("3.2")
				.addNode("3.2.1")
			.getParent().getParent().addNode("3.3")
			;
		tree.addNode("4");
		tree.addNode("5")
			.addNode("5.1")
			.getParent().addNode("5.2")
				.addNode("5.2.1")
				.getParent().addNode("5.2.2")
				.getParent().addNode("5.2.3")
				.getParent().addNode("5.2.4")
				.getParent().addNode("5.2.5")
			.getParent().getParent().addNode("5.3")
			.getParent().addNode("5.4")
				.addNode("5.4.1")
				.getParent().addNode("5.4.2")
				.getParent().addNode("5.4.3")
				.getParent().addNode("5.4.4")
				.getParent().addNode("5.4.5")
			.getParent().getParent().addNode("5.5")
			;
		
		return tree;
	}
	
}
