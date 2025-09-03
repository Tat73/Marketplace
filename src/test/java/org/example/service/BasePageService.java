package org.example.service;

import org.example.util.Waiters;

import java.util.logging.Logger;

public class BasePageService {
    Waiters waiters = new Waiters();

    public static final Logger log = Logger.getLogger(BasePageService.class.getName());

}
