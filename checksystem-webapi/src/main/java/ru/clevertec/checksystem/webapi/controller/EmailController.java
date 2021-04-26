package ru.clevertec.checksystem.webapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.clevertec.checksystem.core.dto.email.EmailDto;
import ru.clevertec.checksystem.core.dto.email.EventEmailDto;
import ru.clevertec.checksystem.core.service.common.IEmailService;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/emails", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class EmailController {

    private final IEmailService mailService;

    @GetMapping
    ResponseEntity<Page<EmailDto>> get(Pageable pageable) {
        return new ResponseEntity<>(mailService.getEmailsPage(pageable), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<EmailDto> get(@PathVariable Long id) {
        return new ResponseEntity<>(mailService.getEmailById(id), HttpStatus.OK);
    }

    @GetMapping("/count")
    ResponseEntity<Long> getCount() {
        return new ResponseEntity<>(mailService.getEmailCount(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable Long id) {
        mailService.deleteEmailById(id);
    }

    @PutMapping
    ResponseEntity<EmailDto> update(@RequestBody @Valid EmailDto emailDto) {
        return new ResponseEntity<>(mailService.updateEmail(emailDto), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<EmailDto> create(@RequestBody @Valid EmailDto emailDto) {
        return new ResponseEntity<>(mailService.createEmail(emailDto), HttpStatus.CREATED);
    }

    @GetMapping("{emailId}/eventEmails")
    Page<EventEmailDto> getEventEmails(Pageable pageable, @PathVariable Long emailId) {
        return mailService.getEventEmailsByEmailId(emailId, pageable);
    }
}
