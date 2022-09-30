package com.mucahitarslan.application.servletrequestinfo.controller;

import com.mucahitarslan.application.servletrequestinfo.ClientInfo;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/info")
@Scope("prototype")
public class ClientInformationController {
    private final HttpServletRequest m_request;
    private final ClientInfo m_clientInfo;

    public ClientInformationController(HttpServletRequest m_request, ClientInfo m_clientInfo) {
        this.m_request = m_request;
        this.m_clientInfo = m_clientInfo;
    }

    @GetMapping("/client")
    public ClientInfo getClientInfo()
    {
        return m_clientInfo.setLocalAddress(m_request.getLocalAddr())
                .setRemoteAddress(m_request.getRemoteAddr())
                .setRemoteHost(m_request.getRemoteHost())
                .setLocalPort(m_request.getLocalPort())
                .setRemotePort(m_request.getRemotePort());
    }
}
