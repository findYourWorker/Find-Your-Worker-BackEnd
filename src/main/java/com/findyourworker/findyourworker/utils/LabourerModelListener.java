package com.findyourworker.findyourworker.utils;

import com.findyourworker.findyourworker.entity.Labourer;
import com.findyourworker.findyourworker.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;

public class LabourerModelListener
//        extends AbstractMongoEventListener<Labourer>
{
//    @Autowired
//    private SequenceGeneratorService sequenceGenerator;
//
//    @Override
//    public void onBeforeConvert(BeforeConvertEvent<Labourer> event) {
//        if (event.getSource().getLabourerId() < 1) {
//            event.getSource().setLabourerId(sequenceGenerator.generateSequence(Labourer.SEQUENCE_NAME));
//        }
//    }
}
