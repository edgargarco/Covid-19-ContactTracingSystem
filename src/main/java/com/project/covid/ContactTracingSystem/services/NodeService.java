package com.project.covid.ContactTracingSystem.services;

import com.project.covid.ContactTracingSystem.model.Node;
import com.project.covid.ContactTracingSystem.repository.NodeRepository;
import com.project.covid.ContactTracingSystem.services.common.ICrudOperation;
import com.project.covid.ContactTracingSystem.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
@Transactional
@Service
public class NodeService implements ICrudOperation<Node,Long> {
    private NodeRepository nodeRepository;
    @Autowired
    public void setNodeRepository(NodeRepository nodeRepository) {
        this.nodeRepository = nodeRepository;
    }

    @Override
    public Node createOrUpdate(Node entity) {
        return nodeRepository.save(entity);
    }

    @Override
    public void deleteById(Long aLong) {
        Node node = nodeRepository.findById(aLong).orElse(null);
        if (node != null){
            nodeRepository.delete(node);
        }else {
            Logger.getInstance().getLog(NodeService.class).error("Node ID: "+ aLong+" DOES NOT EXIST");
        }
    }

    @Override
    public Collection<Node> findAll() {
        return nodeRepository.findAll();
    }

    @Override
    public Node findById(Long aLong) {
        return nodeRepository.findById(aLong).orElse(null);
    }
}
